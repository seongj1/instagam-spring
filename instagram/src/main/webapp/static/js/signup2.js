const input_items = document.querySelectorAll(".input-items");

for (let i = 0; i < input_items.length; i++){
    input_items[i].querySelector("input").onkeydown = keydownEvent;
    input_items[i].querySelector("input").onkeyup = keyupEvent;
}

function keydownEvent(e) {
    console.log(e);
    const nextElement = e.target.parentElement.nextElementSibling;
    if (nextElement.className=="input-items" && e.keyCode == 13) {
        nextElement.children[1].focus();
    }
    e.target.classList.add("typed-input");
    e.target.previousElementSibling.classList.add("typed-label");
}

function keyupEvent(e) {
    if (e.target.value.length == 0) {
        e.target.classList.remove("typed-input");
        e.target.previousElementSibling.classList.remove("typed-label");
    }
}

