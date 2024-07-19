import React from 'react'
import { useNavigate } from 'react-router';

export default function Landing() {
    const navigate = useNavigate();
    const checkInHandler = () => {
        navigate('/checkIn');
    }
    const checkOutHandler = () => {
        navigate('/checkOut');
    }
    const addcarHandler = () => {
        navigate('/addcar');
    }
    const addLocationHandler = () => {
        navigate('/addlocation');
    }
    // const updatecarhandler = () => {
    //     navigate('/updatecar');
    // }
  return (
    <div>
        <div className='center'>
        <br/>
        <br />
        <button onClick={checkInHandler}><h2>Check In Car</h2></button>
        <br />
        <br />
        <button onClick={checkOutHandler}><h2>Check Out Car</h2></button>
        <br />
        <br />
        <button onClick={addcarHandler}><h2>Add Car</h2></button>
        <br />
        <br />
        <button onClick={addLocationHandler}><h2>Add Location</h2></button>
        {/* <br /> */}
        {/* <br /> */}
        {/* <button onClick={updatecarhandler}><h2>Update Car</h2></button> */}
        {/* <br /> */}
        {/* <br /> */}
    </div>
    </div>
  )
}
