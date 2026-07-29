/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const result = [], cache = {}

    for (let element of [...arr1, ...arr2]) {
        if (!(element["id"] in cache)) {
            cache[element["id"]]= result.length
            result.push(element)
        } else {
            result[cache[element.id]] = {...result[cache[element.id]], ...element}
        }
    }

    result.sort((obj1, obj2) => obj1.id - obj2.id)
    return result
};