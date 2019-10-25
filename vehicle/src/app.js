console.log(navigator.language);
const internationalize = (dom) => { 
    const key = dom.innerText;
    //fetch value from JSON / server
    dom.innerText = 'german' + key;
    return dom;

}
const items = document.querySelectorAll('li[ffint]');
console.log(items);
items.forEach(dom => internationalize(dom));


document.querySelector("#hack").innerText = 'found id';
document.querySelector(".ff").innerText = 'found class';


