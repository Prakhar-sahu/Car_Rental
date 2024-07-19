import SignUp from "./SignUp";
import Landing from "./Landing";
import React, {useState} from 'react';
import {BrowserRouter,Routes,Route} from "react-router-dom";
import Login from "./Login";
import BookCars from "./BookCars";
import Booking from "./Booking";
import MyBooking from "./MyBooking";

function App() {
  const [c_id,setCId] = useState('');
  const [user_id,setUserId] = useState('');
  const setCIdHandler = (cid) => {
      setCId(cid);
  }
  const setUserIdHandler = (uid) =>{
      setUserId(uid);
  }
  const resetUserIdHandler = ()=>{
      setUserId('');
  }
  const resetCarIdHandler = () =>{
    setCId('');
  }
  return (
    <BrowserRouter>
    <Routes>
      <Route path='/login' element={<Login setId={setUserIdHandler}/>} />
      <Route path='/' element={<SignUp setId={setUserIdHandler}/>} />
      <Route path='/landing' element={<Landing cur_id={user_id} setId={resetUserIdHandler}/>} />
      <Route path='/bookCars' element={<BookCars cur_id={user_id} setCar={setCIdHandler}/>} />
      <Route path='/confirmBooking' element={<Booking cur_id={user_id} cur_car={c_id} />} />
      <Route path='/myBookings' element={<MyBooking cur_id={user_id} resetId={resetCarIdHandler}/>} />
    </Routes>
    </BrowserRouter>
  );
}

export default App;
