const loadModule = async _ => {

    const module = await import('./Modules.js');
    const tractor = new module.default();
    console.log(tractor.message(),module.message,module.speed());


}


loadModule();