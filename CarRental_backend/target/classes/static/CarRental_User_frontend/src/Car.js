import React from 'react'

export default function Car(props) {
    const onBookHandler = () => {
        props.bookme(props.cur_car.id);
    }
    //const url = "file:///C:/Users/siddh/Desktop/Cars/";
    return (
    <tr key={props.cur_car.id}>
    <td className='imgCol'><img src={process.env.PUBLIC_URL+props.cur_car.image}/></td>
    <td className='detailsCol'>
        <h4>Make : {props.cur_car.make}</h4>
        <h4>Model : {props.cur_car.model}</h4>
        <h4>Year Of Manufacture : {props.cur_car.yearOfManufacture}</h4>
        <h4>Cost Per KM : {props.cur_car.costPerKM}</h4>
        <h4>No. of seats : {props.cur_car.numberOfSeats}</h4>
        <h4>Mileage : {props.cur_car.mileage}</h4>
    </td>
    <td className='buttonCol' onClick={onBookHandler}><button>Book</button></td>
    </tr>
    );
}
