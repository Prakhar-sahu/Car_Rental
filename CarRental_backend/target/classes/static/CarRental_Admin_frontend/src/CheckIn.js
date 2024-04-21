import React, {useState} from 'react';
import './style.css';
import axios from 'axios'
import Bill from './Bill';

export default function CheckIn() {
    const [formData,setFormData] = useState({
        email:'',
        endM:'',
        fine:'',
        returnDate:''
    });
    const {email,endM,fine,returnDate} = formData;
    const onChangeHandler = (event)=> setFormData({...formData,[event.target.name]:event.target.value});
    const [flag,setFlag] = useState(false);
    const [res,setRes] = useState({});
    const onSubmitHandler = () => {
        const params = JSON.stringify({
            "email":email,
            "endM":endM,
            "returnDate":returnDate,
            "fine":fine
        });
        axios
      .post("http://localhost:8080/carrentals/admin/checkIn", params, {
        "headers": {
        "content-type": "application/json",
        },
      })
      .then((response) => {
        setFlag(true);
        setRes(response.data);
      });
    }
  return (
    <div>
    <div className="center">
        <h2>Check In Car</h2>
        <br/>
        <label className='form_label'>User Email</label><input className='form_input' name='email' value={email} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Enter end mileage of Car</label><input className='form_input' name='endM' value={endM} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Return Date</label><input className='form_input' type='date' name='returnDate' value={returnDate} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Any additional costs</label><input className='form_input' name='fine' value={fine} onChange={onChangeHandler}></input>
        <br/>
        <button onClick={onSubmitHandler}>Submit</button>
        <br/>
        <br/>
        </div>
        {flag && <Bill content={res}/>}
    </div>
  )
}
