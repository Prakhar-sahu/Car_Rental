import React from 'react'
import './style.css';

export default function Bill(props) {
  return (
    <div className='center'>
        <h1>Bill</h1>
        <br/>
        <h2>Rental Cost : {props.content.usageCharges}</h2>
        <h2>AddOn Cost : {props.content.addonCost}</h2>
        <h2>Taxes : {props.content.taxes}</h2>
        <br/>
        <h1>Total : {props.content.total}</h1>
    </div>
  )
}
