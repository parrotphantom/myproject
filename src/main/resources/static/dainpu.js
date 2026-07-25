const button = document.querySelectorAll("button");
const boxes = document.querySelectorAll(".shiyong");
button.forEach(button => {
    button.addEventListener("click",()=>{
        boxes.forEach(shiyong =>shiyong.classList.remove("active"))
        const newid = button.dataset.id;
        const button1 =document.getElementById(newid);
        if (button1){
            button1.classList.add("active");
        }

    })})

