import React from 'react';
import {BrowserRouter,Routes,Route} from "react-router-dom";
import CheckIn from './CheckIn';
import CheckOut from './CheckOut';
import Landing from './Landing';
import Login from "./Login";
import AddCarForm from './Addcar';
import CreateRentalLocation from './addlocation';
import EditCarForm from './Updatestatus';
import UpdateCarStatus from './Updatestatus';

function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<Login/>} />
      <Route path='/landing' element={<Landing/>}/>
      <Route path='/checkIn' element={<CheckIn/>}/>
      <Route path='/checkOut' element={<CheckOut/>}/>
      <Route path='/addcar' element={<AddCarForm/>}/>
      <Route path='/addlocation' element={<CreateRentalLocation/>}/>
      {/* <Route path='/updatecar' element={<UpdateCarStatus/>}/> */}
    </Routes>
    </BrowserRouter>
  );
}

export default App;
