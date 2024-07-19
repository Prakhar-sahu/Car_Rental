import React, { useState } from 'react';
import axios from 'axios';
import './Addcar.css'
export default function CreateRentalLocation() {
    const [locationId, setLocationId] = useState('');
    const [centreName, setCentreName] = useState('');
    const [address, setAddress] = useState('');
    const [pincode, setPincode] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/createRentalLocation', {
                locationId,
                centreName,
                address,
                pincode
            });
            console.log('Response:', response.data);
            // Handle success or navigate to another page
            setLocationId('');
            setCentreName('');
            setAddress('');
            setPincode('');
        } catch (error) {
            console.error('Error:', error);
            // Handle error
        }
    };

    return (
        <div className="add-car-form">
            <h1>Create Rental Location</h1>
            <form onSubmit={handleSubmit}>
                <label>
                    Location ID:
                    <input
                        type="text"
                        value={locationId}
                        onChange={(e) => setLocationId(e.target.value)}
                    />
                </label>
                <br />
                <label>
                    Centre Name:
                    <input
                        type="text"
                        value={centreName}
                        onChange={(e) => setCentreName(e.target.value)}
                    />
                </label>
                <br />
                <label>
                    Address:
                    <input
                        type="text"
                        value={address}
                        onChange={(e) => setAddress(e.target.value)}
                    />
                </label>
                <br />
                <label>
                    Pincode:
                    <input
                        type="text"
                        value={pincode}
                        onChange={(e) => setPincode(e.target.value)}
                    />
                </label>
                <br />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
}
