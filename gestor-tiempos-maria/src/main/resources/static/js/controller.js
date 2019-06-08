const URL = "https://localhost:8443";
$(document).ready(function (e) {




    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////--------CREATE CATEGORY-----------////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////

    /*$("#createCategory").submit(function (event) {
         //get the form data
      var formData = {
             "name": $("input[name='categoryName']").val()
         }
         $.ajax({
             type: 'POST',
             url: URL + "/api/categories/prueba",
             //data:JSON.stringify(formData.name),
             headers: {
                 "Content-Type": "application/json"
             }
         }).done(function(data){
             console.log("EXITO, estamos en el done de AJAX");
             //console.log (data);
         });
     });*/

    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////----------SET CATEGORY------------////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#pruebaPOST").click(function () {
        console.log("Estamos dentro de prueba POST");
        var categoryName = document.getElementById("inputNameNewCategory").value;
        console.log(categoryName);
        var token = document.getElementById("tokenValue").value;
        console.log(token);
        $.ajax({
            type: 'POST',
            url: URL + "/category/create",
            //data:JSON.stringify(categoryName),
            formdata: {

            }


        }).done(function (data) {
            console.log("EXITO, estamos en el done de AJAX");
            //console.log (data);
        });
    });
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////--------DELETE CATEGORY-----------////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#deleteCategory").click(function () {

    });
    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////--------CREATE EVENT-----------/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#createEvent").click(function () {

    });

    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////----------SET EVENT------------/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#setEvent").click(function () {

    });
    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////--------DELETE EVENT-----------/////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#deleteEvent").click(function () {

    });
    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////--------CREATE INTERVAL-----------////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#createInterval").click(function () {

    });

    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////----------SET INTERVAL------------////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#setInterval").click(function () {

    });

    /////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////--------DELETE INTERVAL-----------////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    $("#deleteInterval").click(function () {

    });
})




$('.datetimepicker').datetimepicker({
    icons: {
        time: "fa fa-clock-o",
        date: "fa fa-calendar",
        up: "fa fa-chevron-up",
        down: "fa fa-chevron-down",
        previous: 'fa fa-chevron-left',
        next: 'fa fa-chevron-right',
        today: 'fa fa-screenshot',
        clear: 'fa fa-trash',
        close: 'fa fa-remove'
    }
});
function accesscontrol() {
    console.log(user);
    console.log(password);
    var user = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if ((user == "grupo12") && (password == "1234")) {
        var url = "dashboard.html";
        $(location).attr('href', url);
    } else {
        alert("User name or password incrorrect");
    }
}
function enter(e) {
    var push = (document.all) ? e.keyCode : e.which;
    if (push == 13) {
        accesscontrol();
    }
}
function loginindex(data) {
    document.getElementById("login").style.display = "none";
    switch (data) {
        case "teacher": {
            document.getElementById("loginStudent").style.display = "block";
            break;
        }
        case "student": {
            document.getElementById("loginTeacher").style.display = "block";
            break;
        }
        case "visitor": {
            //goTo(); -->Irá directamente al dashboard con las opciones de visitante
            break;
        }
    }
}
function goTo(route) {
    console.log("Ha entrado en route");
    //Hide all sections and show the section selected
    document.getElementById("event").style.display = "none";
    document.getElementById("time").style.display = "none";
    document.getElementById("category").style.display = "none";
    document.getElementById("view").style.display = "none";
    document.getElementById(route).style.display = "block";

    //Change css of sidebar (active class)
    var x = document.getElementById("nav_category").className;
    console.log(x);
    document.getElementById("nav_category").className = "nav-item";

    document.getElementById("nav_time").className = "nav-item";
    document.getElementById("nav_event").className = "nav-item";
    //document.getElementById("nav_view").className = "nav_item";
    document.getElementById("nav_" + route).className = "nav-item active";
}
/*
document.getElementById('actualidad').onchange = function () {
    document.getElementById('dateDisabled').disabled = this.checked;
};*/

function registerview(id) {
    console.log("ESTAMOS DENTRO");
    document.getElementById('loginModalContent1').style.display = "none";
    document.getElementById('loginModalContent2').style.display = "none";
    document.getElementById(id).style.display = "block";
}