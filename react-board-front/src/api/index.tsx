import axios from "axios";

export const request =  (method :string, url : string, data? : Object) =>{
    return axios({
        method,
        url : url,
        data,
    }).then((res)=>{
        return res.data
    }).catch( res=>{
        throw res.response.data;
    });
}
