
function VisibleMenu(id){
    if(id == "registr"){
        let blockForMessage = document.getElementById("messageregistr");
        blockForMessage.innerText = "";
        document.querySelector(".login-text").value = "";
        document.querySelector(".password-text").value = "";

        let element = document.getElementById("registr-menu");
        element.classList.toggle("mystyleHidden");
        element.classList.toggle("mystyleVisible");
    };
    if(id =="door"){
        document.getElementById("messageenterence").innerText = "";

        document.querySelector("#login-text").value = "";
        document.querySelector("#password-text").value = "";

        let elementDoor = document.getElementById("door-menu");
        elementDoor.classList.toggle("mystyleHidden");
        elementDoor.classList.toggle("mystyleVisible");
    };
}

function fillMessageAR(element, message){
    element.innerText = message;

    if (!message=="") {
        element.style.color = "#FF6347";
        element.style.fontSize = "12px";
        element.classList.remove("mystyleHidden");
        element.classList.add("mystyleVisible");
    }else{
        element.classList.add("mystyleHidden");
        element.classList.remove("mystyleVisible");
    }
}

function fillMessageFindRoom(element, message){
    element.innerText = message;
    element.style.color = "#FF6347";
    element.style.fontSize = "20px";
}

function fillMessageAfterBook(element, message){
    element.innerText = message;
    element.style.color = "#FF6347";
    element.style.fontSize = "14px";

}
function Validate(id){
    regexplogin = /\S{3,10}/i;
    regexppassword = /\S{5,}/i;

    if (id == "button-registr"){
        let login = document.querySelector(".login-text").value;
        let password = document.querySelector(".password-text").value;
        let messageForUser = "";
        let blockForMessage = document.getElementById("messageregistr");

        if (!regexplogin.test(login)){
            messageForUser = messageForUser + "Логин - 3-10 симв."
        }

        if (!regexppassword.test(password)) {
            messageForUser = messageForUser == "" ? "Пароль - мин. 5 симв." : messageForUser +
                "\nПароль - мин. 5 симв."
        }

        if (!messageForUser == "") {
            fillMessageAR(blockForMessage, messageForUser);
        }

        if (regexplogin.test(login) && regexppassword.test(password)) {

            let body = JSON.stringify({
                login: login,
                password: password
            });

            fetch('/registration', {
                method: 'POST',
                headers:{
                    'Content-type': 'application/json'
                },
                body: body
            }).then(response=>(response.text())).then(data=> {
                fillMessageAR(blockForMessage, data);
            });
        }
    };

    if (id == "button-enterence"){

        let login = document.querySelector("#login-text").value;
        let password = document.querySelector("#password-text").value;
        let blockForMessage = document.getElementById("messageenterence");
        let messageForUser = "";

        if(!regexplogin.test(login)){
            messageForUser = messageForUser + "Логин - 3-10 симв."
        }

        if(!regexppassword.test(password)){
            messageForUser = messageForUser == "" ? "Пароль - мин. 5 симв." : messageForUser +
                "\nПароль - мин. 5 симв."
        }

        if(!messageForUser == ""){
            fillMessageAR(blockForMessage, messageForUser);
        }

        if(regexplogin.test(login)&&regexppassword.test(password)){
            let body = JSON.stringify({
                login: login,
                password: password
            });

            fetch('/authorization', {
                method: 'POST',
                headers:{
                    'Content-type': 'application/json'
                },
                body: body
            }).then(response=>(response.text())).then(data=> {
                if(data!="Not find") {
                    VisibleMenu("door");
                    let children = document.getElementById("door").childNodes;
                    for (var i = 0; i < children.length; ++i) {
                        children[i].innerText = data;

                    }
                }else{
                    fillMessageAR(blockForMessage, "Ошибка логина/пароля");
                }
            });
        }
    }

    if (id == "button-filter"){
        let arriveDateString = document.querySelector("#arrive").value;
        let awayDateString = document.querySelector("#away").value;
        let blockForMessage = document.querySelector("#date-message");
        let currentDate = new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate(), 0, 0 ,0);
        let guests = document.querySelector("#guest").value;

        blockForMessage.innerText = "";

        if(arriveDateString==""||awayDateString==""){
            fillMessageFindRoom(blockForMessage, "Необходимо заполнить даты заезда и выезда");

        }
        if(arriveDateString!=""&&awayDateString!=""){

            let arriveDate = new Date(arriveDateString.split("-")[0], arriveDateString.split("-")[1]-1, arriveDateString.split("-")[2], 0, 0, 0);
            let awayDate = new Date(awayDateString.split("-")[0], awayDateString.split("-")[1]-1, awayDateString.split("-")[2], 0, 0, 0);
            if(arriveDate>awayDate){
                fillMessageFindRoom(blockForMessage, "Дата выезда не может наступить раньше чем дата заезда");
            }
            if(arriveDate.getTime()==awayDate.getTime()){
                fillMessageFindRoom(blockForMessage, "Дата выезда не может быть равна дате заезда");
            }
            if(arriveDate<currentDate||awayDate<currentDate){
                fillMessageFindRoom(blockForMessage, "Дата выезда и заезда не могут быть в прошлом");
            }
            if(guests!=""&&arriveDate.getTime()!=awayDate.getTime()&&arriveDate>=currentDate&&awayDate>currentDate){
                sessionStorage.setItem("dateFrom", arriveDateString);
                sessionStorage.setItem("dateTo", awayDateString);
                sessionStorage.setItem("roomGuest", guests);

                let body = JSON.stringify(
                    {dateFrom: arriveDate,
                    dateTo: awayDate,
                    guestQuant: guests
                });

                fetch('/freerooms', {
                    method: 'POST',
                    headers: {
                        'Content-type': 'application/json'
                    },
                    body: body
                }).then((response)=>response.json()).then((data)=> {
                    if(data===null){
                        fillMessageFindRoom(blockForMessage, "Свободных номеров нет");
                    }
                    else{
                        replaceBody(data);
                    }
                });
            }
        }
        if(guests==""){
            fillMessageFindRoom(blockForMessage, "Укажите количество гостей");
        }
    }
}
function Book(elem){

    let surname = elem.parentNode.parentNode.querySelector("#surname").value;
    let name = elem.parentNode.parentNode.querySelector("#name").value;
    let phone = elem.parentNode.parentNode.querySelector("#phone").value;
    let messageBlock = elem.parentNode.nextElementSibling;

    regexpName = /[A-Za-zА-яЁё]{2,}/;
    regexpPhone = /\+380[0-9]{9}/;

    messageBlock.innerText = "";

    if(surname==""||name==""||phone==""){
        fillMessageAfterBook(messageBlock, "Укажите фамилию, имя и телефон");
    }else{
        if(!regexpName.test(name)||!regexpName.test(surname)){
            fillMessageAfterBook(messageBlock, "Укажите фамилию и имя верно");
        }
        if(!regexpPhone.test(phone)){
            fillMessageAfterBook(messageBlock, "Укажите телефон в формате '+380XXXXXXXXX'");
        }
        if(regexpName.test(name)&&regexpName.test(surname)&&regexpPhone.test(phone)){
            let arriveDateString = sessionStorage.getItem("dateFrom");
            let awayDateString = sessionStorage.getItem("dateTo");
            let roomGuest = sessionStorage.getItem("roomGuest");

            let arriveDate = new Date(arriveDateString.split("-")[0], arriveDateString.split("-")[1]-1, arriveDateString.split("-")[2], 0, 0, 0);
            let awayDate = new Date(awayDateString.split("-")[0], awayDateString.split("-")[1]-1, awayDateString.split("-")[2], 0, 0, 0);
            let room =
                {id: elem.id,
                    roomGuest: "",
                    info: "",
                    price: "",
                    linkPhoto: ""
                };

            let order = JSON.stringify(
                {dateFrom: arriveDate,
                    dateTo: awayDate,
                    room: room,
                    guestQuant: roomGuest,
                    surname: surname,
                    name: name,
                    phone: phone

                });

            fetch('/bookroom', {
                method: 'POST',
                headers:{
                    'Content-type': 'application/json'
                },
                body: order
            }).then(response=>(response.text())).then(data=>{
                messageBlock.innerText = data;
                messageBlock.style.color = "#FF6347";
            });
        }
    }
}
function replaceBody(data){

       let body = document.querySelector("#main");
       body.innerHTML = "";

       let newHtml = "";
       body.removeAttribute("id");
       body.classList.add("main");
        for (var i = 0; i < data.length; i++){
         newHtml = newHtml + "<div class=\"roominfo\">\n" +
             "       <div class=\"roomsphoto\">\n" +
             "        <img src=" + data[i].linkPhoto  + ">\n" +
             "       </div>\n" +
             "       <div class=\"describe\">" + data[i].info + "</div>\n" +
             "       <div class=\"other\">\n" +
             "       <div id=\"price\">" + data[i].price + "грн.</div>\n" +
             "       <div class=\"surname-name\">\n" +
             "       <input type=\"text\" id=\"surname\" placeholder=\"Фамилия\"/>\n" +
             "       <input type=\"text\" id=\"name\" placeholder=\"Имя\"/>\n" +
             "       </div>" + "<div class=\"phone-book\">\n" +
             "       <input type=\"text\" id=\"phone\" placeholder=\"Телефон\"/>\n" +
             "       <button " + "id=" + "" + data[i].id.toString() + "" + " onclick=\"Book(this)\">Бронировать</button>\n" +
             "       </div>\n" +
             "       <div> </div>\n" +
             "        </div>\n" +
             "       </div>";
        }
        body.innerHTML = newHtml;
}