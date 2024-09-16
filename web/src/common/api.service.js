import axios from "axios";


export function get(path = ''){
    axios.get(path).catch(err => { // backendden response başarılı döndüğünde mesaj basmka veya bişeyler yapmak istersek then kullanılıyor. Hatalı döndüğünde hatayı ayıklamak istersek de catch kullanılıyor
        throw new Error('Http Get Error : api.service');
    })
}

export function post(path = '', params){
    axios.get(path,params).catch(err => { // backendden response başarılı döndüğünde mesaj basmka veya bişeyler yapmak istersek then kullanılıyor. Hatalı döndüğünde hatayı ayıklamak istersek de catch kullanılıyor
        throw new Error('Http Post Error : api.service');
    })
}