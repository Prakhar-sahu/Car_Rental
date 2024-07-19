import React, {useState} from 'react';
import './style.css';
import axios from 'axios';
import { useNavigate } from 'react-router';

export default function MyBooking(props) {
    const navigate = useNavigate();
    // console.log("Printing curid");
    // console.log(props.cur_id);
    React.useEffect(() => {
        axios.get('http://localhost:8080/carrentals/mybookings/'+props.cur_id).then((response) => {
        
          response.data.vr.fromDate = response.data.vr.fromDate.slice(0,10);
          response.data.vr.dueDate = response.data.vr.dueDate.slice(0,10)
          setRes1(response.data.car);
          setRes2(response.data.vr);
        });
      });
    const [r1,setRes1] = useState('');
    const [r2,setRes2] = useState('');
    const cancelHandler = () => {
        axios.get('http://localhost:8080/carrentals/cancel/'+props.cur_id).then((response) => {
            props.resetId();
            alert("Cancelled Sucessfully");
            navigate('/landing');
        });
    };
  return (
    <div>
    <div className="center">
        <h4>From : {r2.fromDate}</h4>
        <h4>To : {r2.dueDate}</h4>
    </div>
    <br/>
    <br/>
    <table key="1">
        <thead key="2">
            <tr key="3">
                <th key="4" className='tableHead'>Car Image</th>
                <th key="5" className='tableHead'>Car Details</th>
                <th key="6" className='tableHead'>Cancel</th>
            </tr>
        </thead>
        <tbody key="7">
            <tr key={r1.id}>
                <td className='imgCol'><img src={process.env.PUBLIC_URL+r1.image}/></td>
                <td className='detailsCol'>
                <h4>Make : {r1.make}</h4>
                <h4>Model : {r1.model}</h4>
                <h4>Year Of Manufacture : {r1.yearOfManufacture}</h4>
                <h4>Cost Per KM : {r1.costPerKM}</h4>
                <h4>No. of seats : {r1.numberOfSeats}</h4>
                <h4>Mileage : {r1.mileage}</h4>
                </td>
                <td className='buttonCol' onClick={cancelHandler}><button>Cancel</button></td>
            </tr>
        </tbody>
    </table>
    </div>
  )
}
