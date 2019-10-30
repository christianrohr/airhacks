

navigator.serviceWorker.register('/FFWorker.js').
    then(r => console.log(r));


window.setTimeout(_ => fetch('/hello.txt').then(r => console.log(r)), 2000);


