var username = "John";
var firstCharCode = username.charCodeAt(0);
if (firstCharCode >= 65 && firstCharCode <= 90) {
    console.log("Hello ! " + username);
}
else {
    console.error("Error: Name must start with UpperCase Letter");
}
