function submitForm(value){
            var elem = document.createElement('input');
            elem.type = "hidden"; 
            elem.value = value;
            elem.name = "command";
            document.querySelector("#menu_nav").appendChild(elem);
            document.querySelector("#menu_nav").submit();
            document.querySelector("#menu_nav").removeChild(elem);
        }


