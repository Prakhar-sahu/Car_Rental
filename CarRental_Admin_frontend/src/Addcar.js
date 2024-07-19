import React, { useState } from 'react';
import axios from 'axios';
import './Addcar.css';

export default function AddCarForm() {
    const [formData, setFormData] = useState({
        licensePlateNumber: '',
        make: '',
        model: '',
        yearOfManufacture: '',
        mileage: '',
        numberOfSeats: '',
        carStatus: '',
        carLocationId: '',
        costPerKM: '',
        image: ''
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post('http://localhost:8080/carrentals/addCar', formData)
            .then((res) => {
                alert('Car added successfully!');
                setFormData({
                    licensePlateNumber: '',
                    make: '',
                    model: '',
                    yearOfManufacture: '',
                    mileage: '',
                    numberOfSeats: '',
                    carStatus: '',
                    carLocationId: '',
                    costPerKM: '',
                    image: ''
                });
            })
            .catch((err) => {
                alert('Error adding car');
            });
    };
    

    return (
        <form className="add-car-form" onSubmit={handleSubmit}>
            <label>
                License Plate Number:
                <input type="text" name="licensePlateNumber" value={formData.licensePlateNumber} onChange={handleChange} />
            </label>
            <label>
                Make:
                <input type="text" name="make" value={formData.make} onChange={handleChange} />
            </label>
            <label>
                Model:
                <input type="text" name="model" value={formData.model} onChange={handleChange} />
            </label>
            <label>
                Year of Manufacture:
                <input type="number" name="yearOfManufacture" value={formData.yearOfManufacture} onChange={handleChange} />
            </label>
            <label>
                Mileage:
                <input type="number" name="mileage" value={formData.mileage} onChange={handleChange} />
            </label>
            <label>
                Number of Seats:
                <input type="number" name="numberOfSeats" value={formData.numberOfSeats} onChange={handleChange} />
            </label>
            <label>
                Car Status:
                <input type="text" name="carStatus" value={formData.carStatus} onChange={handleChange} />
            </label>
            <label>
                Car Location ID:
                <input type="text" name="carLocationId" value={formData.carLocationId} onChange={handleChange} />
            </label>
            <label>
                Cost Per KM:
                <input type="number" name="costPerKM" value={formData.costPerKM} onChange={handleChange} />
            </label>
            <label>
                Image URL:
                <input type="text" name="image" value={formData.image} onChange={handleChange} />
            </label>
            <button type="submit">Add Car</button>
        </form>
    );
}
