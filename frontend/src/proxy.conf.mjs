export default {
    "/api": {
        "target": process.env.API_URL,
        "secure": false,
        "pathRewrite": {
        "^/api": ""
        }
    }
}