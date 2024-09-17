import axios from "axios";


export function get(path = ''){
    return axios.get(path).catch(err => { // backendden response başarılı döndüğünde mesaj basmka veya bişeyler yapmak istersek then kullanılıyor. Hatalı döndüğünde hatayı ayıklamak istersek de catch kullanılıyor
        console.log(err)
        throw new Error('Http Get Error : api.service', err);
    })
}

export function post(path = '', params){
    return axios.get(path,params).catch(err => { // backendden response başarılı döndüğünde mesaj basmka veya bişeyler yapmak istersek then kullanılıyor. Hatalı döndüğünde hatayı ayıklamak istersek de catch kullanılıyor
        console.log(err)
        throw new Error('Http Post Error : api.service', err);
    })
}