const account_nav_list = document.querySelectorAll('.account-nav-list > li');
const uri = location.href;

window.onload = addSelectedBorder;


function addSelectedBorder(event) {
    console.log(event);
    const current_page = findPage();
    if (current_page == "account") {
        account_nav_list[0].className = "selected";
    } else if (current_page == "accountPassword") {
        account_nav_list[1].className = "selected";
    }
}

function findPage() {
    const comma_index = uri.lastIndexOf(".");
    const last_slach_index = uri.lastIndexOf("/") + 1;
    const current_page = uri.substring(last_slach_index, comma_index);

    return current_page;
}