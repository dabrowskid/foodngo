import React from "react";
import ReactDOM from "react-dom";

import Button from '@material-ui/core/Button';

import CssBaseline from '@material-ui/core/CssBaseline';

import {BrowserRouter as Router, Link, Route} from 'react-router-dom';

const App = () => (
    <Button variant="contained" color="primary">
        Hello World
    </Button>
);

const Home = () => (
    <div>Hello home</div>
);

const About = () => (
    <div>Hello about</div>
);

const RoutedApp = () => {
    return (
        <Router>
            <div className="container">

                <Link to="/"><Button variant="contained" color="primary">
                    Hello World
                </Button></Link>

                <Link to="/about"><Button variant="contained" color="primary">
                    Hello 2
                </Button></Link>


                <Route exact path="/" component={Home}/>
                <Route path="/about" component={About}/>
            </div>
        </Router>
    );
};



const Index = () => {
    return <div><CssBaseline/>Hello React, or not! <App/><RoutedApp/></div>;
};

ReactDOM.render(<Index/>, document.getElementById("index"));

