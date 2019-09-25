import React from 'react';
import Header from "./Layouts/Header";
import {BrowserRouter, Route} from 'react-router-dom';
import CashierList from "./Components/CashierList";
import Cashier from "./Components/Cashier"

export default class App extends React.Component {

    constructor() {
        super();
        this.state = {cashiers: []}
    }



    render() {
        return (
            <BrowserRouter>
                <div className="App">
                    <Header/>
                    <Route exact path='/' render={
                        (props) =>
                            <CashierList {...props} cashiers={this.state.cashiers}/>
                    }/>
                    <Route path='/monitor/:cashier_id' component={Cashier}/>
                </div>
            </BrowserRouter>
        );
    }
}


