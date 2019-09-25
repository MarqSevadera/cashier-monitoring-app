import React from 'react';
import {Paper, Typography, makeStyles, Grid} from "@material-ui/core";
import {Link} from "react-router-dom";
import Avatar from "@material-ui/core/Avatar";
import cash_register from "../static/images/cash-register.png"

const useStyles = makeStyles(theme => ({
    root: {
        padding: theme.spacing(5),
        margin: theme.spacing(5),
        width: 380,
        backgroundColor: "#32ad53"
    }

}));

export default function CashierCard(props) {

    const {cashierId, counterName} = props.cashierData;
    const classes = useStyles()

    return (
        <Link to={'/monitor/' + cashierId}  style={{ textDecoration: 'none' }}>
            <Paper className={classes.root} elevation={8}>
                <Grid container justify={"center"}>
                    <img alt="Cashier" src={cash_register} style={{width: "90px" , marginBottom:"35px"}}/>
                </Grid>
                <Typography align="center" variant="h3">{counterName}</Typography>
            </Paper>
        </Link>
    );

}