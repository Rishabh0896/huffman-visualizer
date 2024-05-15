const baseURL = 'http://localhost:8080';

export function getHuffmanAssets(text) {
	return fetch(`${baseURL}/compress`, {
		method: 'POST',
		headers: {
		'Content-Type': 'application/json'
	},
	body: text});
}
