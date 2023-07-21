function validateRadio(radioName) {
    let result = false;

    //Obtengo los radios
    let elements = document.getElementsByName(radioName);
    //Obtengo el div del mensaje de error.
    let errorMessage = elements[0].parentElement.querySelector(".error-message");
    //Limpio el error
    errorMessage.style.display = "none";
    for (i in elements) {
        if (elements[i].checked) {
            result = true
        }
    }

    if (!result) {
        //Si no es valido muestro el error
        errorMessage.style.display = "block";
    }
    return result;
}

function showCountries() {
    let radios = document.getElementsByName("realizo-viaje");
    radios.forEach(element => {
        if (element.value == 'si' && element.checked) {
            document.getElementById("country-container").style.display = "block";
        }

        if (element.value == 'no' && element.checked) {
            document.getElementById("country-container").style.display = "none";
        }
    });
}


function validate() {
    let isValid = true;

    //Valido cada uno de los campos
    if (!validateRadio("tos")) {
        isValid = false;
    }

    if (!validateRadio("fiebre")) {
        isValid = false;
    }

    if (!validateRadio("dolordecabeza")) {
        isValid = false;
    }

    if (!validateRadio("dgarganta")) {
        isValid = false;
    }

    if (!validateRadio("drespirar")) {
        isValid = false;
    }

    if (isValid) {
        showMessage();
    }

    return false;
}

function showMessage() {
    let sicknessCount = 0;

    //Traigo todos los radios con la clase sickness-radio
    let sicknesRadios = document.getElementsByClassName("sickness-radio");

    //Cuento los radio que estan marcados como "si"
    for (i = 0; i < sicknesRadios.length; i++) {
        let element = sicknesRadios[i];
        if (element.value == 'si' && element.checked) {
            sicknessCount++;
        }
    }

    //Asigno el contador al elemento con el id sickness-count
    document.getElementById("sickness-count").innerHTML = sicknessCount;

    //Muestro el mensaje
    if(sicknessCount>3){
        var x = document.getElementById("toastMessageAlert");
        x.className = "show";
    }else{
        var x = document.getElementById("toastMessage");
    x.className = "show";
    }


    //Despues de un tiempo lo escondo
    setTimeout(function () {
        x.className = x.className.replace("show", "");
    }, 4000);
}
