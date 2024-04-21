import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router';
import './landingcss.css';

export default function Landing(props) {
    const navigate = useNavigate();
    const [myName, setName] = useState('');

    const logoutHandler = () => {
        props.setId();
        navigate('/login');
    }

    const bookCarHandler = () => {
        navigate('/bookCars');
    }

    const myBookingHandler = () => {
        navigate('/myBookings');
    }

    const deleteHandler = () => {
        axios.get(`http://localhost:8080/carrentals/deleteAccount/${props.cur_id}`).then((res) => {
            alert('Account Deleted Successfully');
            navigate('/signup');
        });
    }

    useEffect(() => {
        axios.get(`http://localhost:8080/carrentals/getName/${props.cur_id}`).then((response) => {
            setName(response.data.person.name);
        });
    }, []);

    return (
        <div className="landing-container">
            <nav className="navbar">
                <h1>Car Rentals</h1>
                <button className="logout-btn" onClick={logoutHandler}>Logout</button>
            </nav>
            <div className='center'>
                <h1 className="greeting">Hello {myName}</h1>
                <button className="action-btn rent-btn" onClick={bookCarHandler}>Rent Car</button>
                <button className="action-btn reservations-btn" onClick={myBookingHandler}>My Reservations</button>
                <button className="action-btn delete-btn" onClick={deleteHandler}>Delete Account</button>
            </div>
            <footer className="footer">
                <div className="footer-links">
                    <a href="https://www.instagram.com/">Instagram</a>
                    <a href="https://www.facebook.com/">Facebook</a>
                    <a href="/location">Location</a>
                    <a href="/contacts">Contacts</a>
                    <a href="/about">About Us</a>
                </div>
            </footer>
        </div>
    )
}
