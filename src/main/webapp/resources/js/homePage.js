var span = document.getElementById("alertExit");
var modal1 = document.getElementById('myModal1');




//LOGİN KONTROL
var loginButton = document.getElementById("loginButton");

loginButton.onclick = function(){
    var username = document.getElementById("userName").value;
    var password = document.getElementById("password").value;

    if((username.length>0 && username.length<5) || (password.length>0 && password.length<5) ){
        document.getElementById("errorText").innerHTML = "Kullanıcı adı veya şifre hatalı. Lütfen tekrar deneyin.";
        modal1.style.display = "block";
        return false;
    }
}


//ŞİFRE KONTROL
var newUserButton = document.getElementById("newUserButton");

newUserButton.onclick = function(){
    var newPassword = document.getElementById("newPassword").value;
    var newPasswordAgain = document.getElementById("newPasswordAgain").value;
    var newUsername = document.getElementById("newUsername").value;
    var newName = document.getElementById("newName").value;
    var newLastName = document.getElementById("newLastName").value;


    if(newUsername.length>0 && newUsername.length<5){
        document.getElementById("errorText").innerHTML = "Kullanıcı adınız beş karakterden uzun olmalıdır.";
        modal1.style.display = "block";
        return false;
    }
    else if(newPassword.length>0 && newPassword.length<5){
        document.getElementById("errorText").innerHTML = "Şifreniz beş karakterden uzun olmalıdır.";
        modal1.style.display = "block";
        return false;
    }
    else if(!(newPassword==newPasswordAgain)){
        document.getElementById("errorText").innerHTML = "Şifreleriniz uyuşmuyor lütfen tekrar deneyin.";
        modal1.style.display = "block";
        console.log(newPassword);
        console.log(newPasswordAgain);
        console.log(newPassword==newPasswordAgain);
        return false;
    }

}

span.onclick = function() {
    modal1.style.display = "none";
}


//EMAİL KONTROL
var messageSendButton = document.getElementById('messageSendButton');
var eMail = document.getElementById('eMail');
messageSendButton.onclick = function(){
    var mailAdress = eMail.value;
    var adresUzunlugu = mailAdress.length;
    var mailDogrulama1 = mailAdress.indexOf("@");
    var mailDogrulama2 = mailAdress.indexOf(".com");
    if((mailAdress.length>0 && mailAdress.length<5) || (mailDogrulama1 <= 0) && (mailAdress.length>0) || (mailDogrulama2 <= 0) && (mailAdress.length>0) || (mailAdress.charAt(adresUzunlugu-1) == ".")){
        document.getElementById("errorText").innerHTML = "Mesajınıza geri dönüş yapabilmemiz için doğru bir mail adresi girmesliniz.<br>Mail adresiniz yanlış lütfen tekrar deneyin.";
        modal1.style.display = "block";
        return false;
    }
    else{
        console.log("dogru adres");
    }
}
span.onclick = function() {
    modal1.style.display = "none";
}

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
    if (event.target == modal1) {
        modal1.style.display = "none";
    }
}
/* Set the width of the side navigation to 250px and the left margin of the page content to 250px and add a black background color to body */
function openNav() {
    document.getElementById("mySidenav").style.width = "250px";
}

/* Set the width of the side navigation to 0 and the left margin of the page content to 0, and the background color of body to white */
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}
function openNav1() {
    document.getElementById("mySidenav1").style.width = "250px";
}
function closeNav1() {
    document.getElementById("mySidenav1").style.width = "0";
}
function openNav2() {
    document.getElementById("mySidenav2").style.width = "250px";
}
function closeNav2() {
    document.getElementById("mySidenav2").style.width = "0";
}