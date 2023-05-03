import React from 'react';
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import Login from "./components/Loging.jsx";
import { ThemeProvider, createTheme } from '@mui/material/styles';
import CssBaseline from '@mui/material/CssBaseline';
import ErrorPage from "./ErrorPage.jsx";
import Register from "./components/register.jsx";
import Send from "./components/send.jsx";
const theme = createTheme({
    palette: {
        primary: {
            main: '#1a237e',
        },
    },
});
const router = createBrowserRouter([
    {
        path: "/",
        element: <Login />,
        errorElement: <ErrorPage />,

    },
    {
        path: "/register",
        protectedRoute: true,
        element: <Register />,
    },
    {
        path: "/send",
        element: <Send />,
    }
]);



const App = () => {
    return (
        <>
            <ThemeProvider theme={theme}>
                <CssBaseline />
                <RouterProvider router={router} />
            </ThemeProvider>
        </>
    );
};

export default App;
