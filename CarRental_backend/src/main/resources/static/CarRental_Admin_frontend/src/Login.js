import React, {useState} from 'react';
import './style.css';
import axios from 'axios'
import { useNavigate } from 'react-router';

export default function Login() {
    const navigate = useNavigate();
    const [formData,setFormData] = useState({
        email:'',
        password:''
    });
    const {email,password} = formData;
    const onChangeHandler = (event)=> setFormData({...formData,[event.target.name]:event.target.value});
    const onSubmitHandler = ()=> {
        const params = JSON.stringify({
            "email":email,
            "password":password
        });
        axios
      .post("http://localhost:8080/carrentals/admin/login", params, {
        "headers": {
        "content-type": "application/json",
        },
      })
      .then((response) => {
        console.log(response.data);
        if(response.data === ""){
            alert("Incorrect email or password");
        }
        else{
            navigate('/landing');
        }
      });
    };
  return (
    <div className="center">
        <h2>Log in</h2>
        <br/>
        <label className='form_label'>Email</label><input className='form_input' name='email' value={email} onChange={onChangeHandler}></input>
        <br/>
        <label className='form_label'>Password</label><input className='form_input' name='password' value={password} onChange={onChangeHandler} type='password'></input>
        <br/>
        <br/>
        <br/>
        <button onClick={onSubmitHandler}>Submit</button>
    </div>
  )
}