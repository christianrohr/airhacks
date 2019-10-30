
self.addEventListener('fetch', e => { 
    console.log('before fetch', e.request);
    
    const response = fetch(e.request);
    return response;

});

self.addEventListener('activate', event => console.log(event));