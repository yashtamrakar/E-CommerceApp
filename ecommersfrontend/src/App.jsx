import { BrowserRouter,Routes,Route } from "react-router-dom";
import MerchantLogin from "./Components/MerchantLogin";
import MerchantSignUp from "./Components/MerchantSignUp";
import LandingPage from "./Components/LandingPage";
import UserLogin from "./Components/UserLogin";
import 'bootstrap/dist/css/bootstrap.min.css';
import MerchantHomePage from "./Components/MerchantHomePage";


function App () {
    return ( 
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<LandingPage/>}/>
                    <Route path="/merchant" element={<MerchantLogin/>}/>
                    <Route path="/user" element={<UserLogin/>}/>
                    <Route path="/merchantsignup" element={<MerchantSignUp/>}/>
                    <Route path="/merchanthomepage" element={<MerchantHomePage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
     );
}
 
export default App;