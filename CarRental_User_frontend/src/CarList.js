import React from 'react'
import Car from './Car'

export default function CarList(props) {
  return (
    <table key="1">
        <thead key="2">
            <tr key="3">
                <th key="4" className='tableHead'>Car Image</th>
                <th key="5" className='tableHead'>Car Details</th>
                <th key="6" className='tableHead'>Book</th>
            </tr>
        </thead>
        <tbody key="7">
            {
                props.cars.map(car => {
                    return(
                    <Car cur_car={car} bookme={props.book}/>
                    );
                })
            }
        </tbody>
    </table>
  )
}
