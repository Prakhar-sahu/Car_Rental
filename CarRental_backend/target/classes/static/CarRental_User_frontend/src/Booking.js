import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
export default function Booking(props) {
    const navigate = useNavigate();
    const [res, setRes] = useState({});
    const [res1, setRes1] = useState({});
    const [form_data, setFormData] = useState({ from: getCurrentDate(), to: '' });

    function getCurrentDate() {
        const date = new Date();
        const year = date.getFullYear();
        let month = date.getMonth() + 1;
        let day = date.getDate();

        if (month < 10) {
            month = '0' + month;
        }
        if (day < 10) {
            day = '0' + day;
        }

        return `${year}-${month}-${day}`;
    }

    useEffect(() => {
        axios.get('http://localhost:8080/carrentals/giveCar/' + props.cur_car).then((response) => {
            setRes(response.data.car);
            setRes1(response.data.rentalLocation);
        });
    }, []);

    const { from, to } = form_data;
    const onChangeHandler = (event) => setFormData({ ...form_data, [event.target.name]: event.target.value });
    const onSubmitHandler = () => {
        const params = JSON.stringify({
            "uid": props.cur_id,
            "cid": props.cur_car,
            "from": from,
            "to": to
        });
        axios
            .post("http://localhost:8080/carrentals/book", params, {
                "headers": {
                    "content-type": "application/json",
                },
            })
            .then((response) => {
                console.log(response.data);
                if (response.data === "Success") {
                    alert("Booking Successful");
                    navigate('/landing');
                } else {
                    alert("Booking Failed");
                }
            });
    }

    return (
        <div>
            <div className="center1">
                <h4>Car Rental Centre Name : {res1.centreName}</h4>
                <h4>Car Rental Centre Address : {res1.address}</h4>
            </div>
            <table key="1">
                <thead key="2">
                    <tr key="3">
                        <th key="4" className='tableHead'>Car Image</th>
                        <th key="5" className='tableHead'>Car Details</th>
                    </tr>
                </thead>
                <tbody key="7">
                    <tr key={res.id}>
                        <td className='imgCol'><img src={process.env.PUBLIC_URL + res.image} alt="Car" /></td>
                        <td className='detailsCol'>
                            <h4>Make : {res.make}</h4>
                            <h4>Model : {res.model}</h4>
                            <h4>Year Of Manufacture : {res.yearOfManufacture}</h4>
                            <h4>Cost Per KM : {res.costPerKM}</h4>
                            <h4>No. of seats : {res.numberOfSeats}</h4>
                            <h4>Mileage : {res.mileage}</h4>
                        </td>
                    </tr>
                </tbody>
            </table>
            <div className="center">
                <label className='form_label'>From Date</label>
                <input className='form_input' type='date' name='from' value={from} onChange={onChangeHandler} disabled></input>
                <br />
                <label className='form_label'>To Date</label>
                <input className='form_input' type='date' name='to' value={to} onChange={onChangeHandler}></input>
                <br />
                <button onClick={onSubmitHandler}>Book</button>
            </div>
        </div>
    )
}
