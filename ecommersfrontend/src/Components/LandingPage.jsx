import { Link } from "react-router-dom";
import "../Styles/LandingPage.css"



const LandingPage = () => {
    return ( 
        <div className="landingpage">
            <Link to ="merchant">
                <img src="https://cdn-icons-png.flaticon.com/128/1999/1999625.png" alt="" /><br />
            Merchant</Link>

            <Link to ="user">
                <img src="https://cdn-icons-png.flaticon.com/128/6997/6997662.png" alt="" /><br />
            User</Link>


        </div>
     );
}
 
export default LandingPage;