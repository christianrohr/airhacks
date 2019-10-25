class AComp extends HTMLElement { 
    connectedCallback() { 
        console.log('visible');
        this.innerHTML = "a.comp";
    }

    onAfterEnter() { 
        console.log('on after enter');
    }

    disconnectedCallback() { 
        console.log('not visible');
    }
}

customElements.define('a-comp',AComp);