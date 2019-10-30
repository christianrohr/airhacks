import './AComp.js';
import './BComp.js';
import './CComp.js';
import { Router } from './vaadin-router.js';

const outlet = document.querySelector('output');
const router = new Router(outlet);
router.setRoutes([
  {path: '/',     component: 'c-comp'},
  {path: '/a',  component: 'a-comp'},
  {path: '/b', component: 'b-comp'},
  {path: '/c/:id', component: 'c-comp'},
]);



