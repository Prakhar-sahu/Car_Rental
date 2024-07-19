import React, {useState} from 'react';
import './style.css';
import axios from 'axios'
import { useNavigate } from 'react-router';
import CarList from './CarList';

export default function BookCars(props) {
    const navigate = useNavigate();
    const [pincode,setPincode] = useState('');
    const [carList,setCarList] = useState([]);
    const [cName,setCName] = useState('');
    const [cAddress,setCAddress] = useState('');
    //const [cId,setCid] = useState('');
    const onSubmitHandler = async () => {
        const res1 = await axios.get('http://localhost:8080/getRentalLocation/'+pincode);
        const res2 = await axios.get('http://localhost:8080/carrentals/'+res1.data.locationId);
        console.log(res1);
        console.log(res2);
        setCName(res1.data.centreName);
        setCAddress(res1.data.address);
        setCarList(res2.data);
    }
    const onBook = (cid) => {
        //setCid(cid);
        props.setCar(cid);
        navigate('/confirmBooking');
    }
    const onChangeHandler = (event)=> setPincode(event.target.value);
  return (
      <div >
    <div className="center1">
        <label className='form_label1'>Search Cars by pincode</label>
        <input className='form_input1' name='pincode' value={pincode} onChange={onChangeHandler}></input>
        <button className='search_btn1' onClick={onSubmitHandler}>Search</button>

        <br />
        <br />
        <h4>Car Rental Centre Name : {cName}</h4>
        <h4>Car Rental Centre Address : {cAddress}</h4>
    </div>
        <div className='center2'>
            <CarList cars={carList} book={onBook}/>
        </div>
        </div>
  )
}

