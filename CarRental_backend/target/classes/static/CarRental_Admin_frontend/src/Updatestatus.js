import React, { useState } from 'react';

const UpdateCarStatus = () => {
    const [licensePlateNumber, setLicensePlateNumber] = useState('');
    const [carStatus, setCarStatus] = useState('');

    const handleUpdate = () => {
        fetch(`http://localhost:8080/cars/${licensePlateNumber}/status/${carStatus}`, {
            method: 'PUT',
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to update car status');
            }
            console.log('Car status updated successfully');
        })
        .catch(error => {
            console.error('Error updating car status:', error);
        });
    };

    return (
        <div>
            <input
                type="text"
                placeholder="Enter license plate number"
                value={licensePlateNumber}
                onChange={(e) => setLicensePlateNumber(e.target.value)}
            />
            <input
                type="text"
                placeholder="Enter new car status"
                value={carStatus}
                onChange={(e) => setCarStatus(e.target.value)}
            />
            <button onClick={handleUpdate}>Update Car Status</button>
        </div>
    );
};

export default UpdateCarStatus;
