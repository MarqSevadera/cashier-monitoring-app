import React from 'react'
import CashierCard from "./CashierCard";
import {Grid} from "@material-ui/core";
import axios from 'axios';


export default class CashierList extends React.Component {
    constructor(){
        super();
        this.state = {
            cashierList : []
        }
    }

    componentDidMount() {
        axios.get("http://localhost:8080/monitor").then(res => {
            console.log(res.data)
            this.setState({
                cashierList: res.data
            })
        }).catch(error =>  console.log(error) );
    }

    render() {
        return (
            <Grid container
                  justify={"center"}>
                {
                    this.state.cashierList.map(cashier =>
                        <CashierCard key={cashier.cashierId}
                                     cashierData={cashier}/>
                    )
                }
            </Grid>
        );
    }

}