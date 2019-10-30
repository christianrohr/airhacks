console.log("Hello Web Standards");
const worker = new Worker('Thread.js');
worker.onmessage = e => payloadReceived(e);
worker.postMessage("tractor");



const payloadReceived = ({data}) => { 
    console.log(data);
}


