import { useState } from "react";
import {
    TextField,
    Button,
    Box,
    Typography,
    Snackbar,
} from "@mui/material";
import axios from "axios";

function Send() {
    const [recipient, setRecipient] = useState("");
    const [message, setMessage] = useState("");
    const [open, setOpen] = useState(false);
    const [snackbarMessage, setSnackbarMessage] = useState("");
    const [snackbarSeverity, setSnackbarSeverity] = useState("");

    const handleRecipientChange = (event) => {
        setRecipient(event.target.value);
    };

    const handleMessageChange = (event) => {
        setMessage(event.target.value);
    };

    const handleClose = () => {
        setOpen(false);
    };

    const handleSuccess = () => {
        setOpen(true);
        setSnackbarMessage("Message sent successfully");
        setSnackbarSeverity("success");
        setRecipient("");
        setMessage("");
    };

    const handleError = (error) => {
        console.error(error);
        setOpen(true);
        setSnackbarMessage("Failed to send message");
        setSnackbarSeverity("error");
    };

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const token = localStorage.getItem('token');
            const response = await axios.post(
                'http://localhost:8080/notifications/notification/send',
                {
                    recipient,
                    message,
                    "number":"24153480"
                },
                {
                    headers: {
                        Authorization: `Bearer ${token}`,
                    },
                }
            );
            console.log(response.data);
            handleSuccess();
        } catch (error) {
            handleError(error);
        }
    };


    return (
        <Box
            sx={{
                display: "flex",
                alignItems: "center",
                justifyContent: "center",
                minHeight: "100vh",
            }}
        >
            <Box
                component="form"
                onSubmit={handleSubmit}
                sx={{
                    display: "flex",
                    flexDirection: "column",
                    width: "100%",
                    maxWidth: 400,
                    p: 2,
                    bgcolor: "#fff",
                    borderRadius: 4,
                    boxShadow: "0px 4px 10px rgba(0, 0, 0, 0.1)",
                }}
            >
                <Typography variant="h5" sx={{ mb: 2 }}>
                    Send Message
                </Typography>
                <TextField
                    label="Recipient"
                    variant="outlined"
                    fullWidth
                    value={recipient}
                    onChange={handleRecipientChange}
                    sx={{ mb: 2 }}
                />
                <TextField
                    label="Message"
                    multiline
                    rows={4}
                    variant="outlined"
                    fullWidth
                    value={message}
                    onChange={handleMessageChange}
                    sx={{ mb: 2 }}
                />
                <Button type="submit" variant="contained" fullWidth sx={{ mb: 2 }}>
                    Send
                </Button>
            </Box>
            <Snackbar
                open={open}
                autoHideDuration={6000}
                onClose={handleClose}
                message={snackbarMessage}
                severity={snackbarSeverity}
                sx={{
                    position: "absolute",
                    bottom: 16,
                }}
            />
        </Box>
    );
}

export default Send;
