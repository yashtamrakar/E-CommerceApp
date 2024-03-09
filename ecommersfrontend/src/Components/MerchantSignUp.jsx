import React, { useState } from 'react'
import "../Styles/MerchantSignUp.css"
import axios from 'axios';

const MerchantSignUp = () => {
    let[name,setname]=useState("");
    let[email,setemail]=useState("");
    let[phone,setphone]=useState("");
    let[gst_number,setgst_number]=useState("");
    let[password,setpassword]=useState("");
    
    let data={name,email,gst_number,phone,password}

    let addMerchant=(e)=>{
      e.preventDefault();
      axios.post(`http://localhost:8080/merchants`,data)
      .then((res)=>{
        console.log(res);
        alert("Data Added Successfull")
      })
      .catch((err)=>{
        console.log("Data Not Found");
      })
    }

  return (
    <div class="merchantsignup">
      <form onSubmit={addMerchant} action="">
        
<label htmlFor="">Name</label>
<input required value={name} onChange={(e)=>{setname(e.target.value)}} type="text"  placeholder='Enter the Name'/>
<label htmlFor="">Gst_Number</label>
<input required type="text" value={gst_number} onChange={(e)=>{setgst_number(e.target.value)}} placeholder='Enter Gst_Number'/>
<label htmlFor="">Email</label>
<input required type="email" value={email}onChange={(e)=>(setemail(e.target.value))} placeholder="Enter the Email" />
<label htmlFor="">Phone No</label>
<input required type="tel" value={phone}onChange={(e)=>(setphone(e.target.value))} pattern="[0-9]{10}"placeholder='Enter Password' />
<label htmlFor="">Password</label>
<input required type="password"value={password}onChange={(e)=>(setpassword(e.target.value))} placeholder="Enter the Password" />
<button className='btn btn-outline-info'>Submit</button>
      </form>
    </div>
  )
}

export default MerchantSignUp
