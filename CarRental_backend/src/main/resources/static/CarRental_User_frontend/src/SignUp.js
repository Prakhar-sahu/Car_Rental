import React, {useState} from 'react';
import './style.css';
import axios from 'axios'
import { useNavigate } from 'react-router';
import {Link} from "react-router-dom";

export default function SignUp(props) {

  const navigate = useNavigate();

  const [formData,setFormData] = useState({
    name:'',
    email:'',
    password:'',
    dob:'',
    licenseExpiryDate:'',
    phone:'',
    licenseNumber:'',
    address:''
  });
  
  const {name,email,password,dob,licenseExpiryDate,phone,licenseNumber,address} = formData;

  const onChangeHandler = (event)=> setFormData({...formData,[event.target.name]:event.target.value});

  const onSubmitHandler = () => {
    const params = JSON.stringify({
        "licenseNumber" : licenseNumber,
        "licenseExpiryDate" : licenseExpiryDate,
        "email" : email,
        "password" : password,
        "accountStatus" : "ACTIVE",
        "type" : "USER",
        "person" : {
            "phone" : phone,
            "dob" : dob,
            "name" : name,
            "address": address
      }
    });
    axios
      .post("http://localhost:8080/carrentals/signup", params, {
        "headers": {
        "content-type": "application/json",
        },
      })
      .then((response) => {
        console.log(response.data);
        props.setId(response.data);
        alert("Registered Sucessfully");
        navigate('/login');
      });
  };
  return (
    <div className="center">
        <h2>Sign Up</h2>
        <br/>
        <label className='form_label'>Email</label><input className='form_input' name='email' value={email} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Password</label><input className='form_input' name='password' value={password} onChange={onChangeHandler} type='password'></input>
        <br/>
        <label className='form_label'>Name</label><input className='form_input' name='name' value={name} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Phone No.</label><input className='form_input' name='phone' value={phone} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Address</label><input className='form_input' name='address' value={address} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>License No.</label><input className='form_input' name='licenseNumber' value={licenseNumber} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>DOB</label><input className='form_input' type='date' name='dob' value={dob} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>License Expiry Date</label><input className='form_input' type='date' name='licenseExpiryDate' value={licenseExpiryDate} onChange={onChangeHandler}></input>
        <br/>
        <br/>
        <button onClick={onSubmitHandler}>Submit</button>
        <br/>
        <br/>
        <p>Already have an account? <Link to="/login">Sign In</Link></p>
    </div>
  )
}
