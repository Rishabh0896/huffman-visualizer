import React, {useState} from 'react';
import {Button, Flex, Layout} from 'antd';
import { Input } from 'antd';
import { Typography } from 'antd';
import {getHuffmanAssets} from "../services/api";

const { Title } = Typography;
const { TextArea } = Input;


function Content() {
	const [text, setText] = useState('');

	const handleChange = (event) => {
		setText(event.target.value);
	};

	const handleClick = () => {
		getHuffmanAssets(text).then((response) => {
			response.json().then((data) => {
				// this data contains frequency map, huffman codes, and tree as json
				console.log(data)
			})
		})
	}


	return (
		<Layout.Content style={contentStyle}>
			<Layout.Content style={leftPanelStyle}>
				<Title>Huffman Visualizer</Title>
				<div style={textStyle}>
					This tool is to visualize the Huffman compression algorithm. Please enter the text to be compressed, and the tool will visualize this algorithm.
				</div>
				<TextArea value={text} onChange={handleChange} rows={6} placeholder="Enter text to be compressed"/>
				<Flex justify="flex-start" align="flex-start">
					<Button onClick={handleClick} type="primary">
						Compress
					</Button>
				</Flex>

			</Layout.Content>
			<Layout.Content style={rightPanelStyle}>
				VIZ PANEL HERE
			</Layout.Content>

		</Layout.Content>
	);
}

const contentStyle = {
	padding: '2rem',
	background: '#fff',
	display: 'flex',
	flexDirection: 'row',
	alignItems: 'flex-start',
	justifyContent: 'start',
};

const leftPanelStyle = {
	width:'40vw',
	padding: '2rem',
	display: 'flex',
	flexDirection: 'column',
	alignItems: 'center',
	justifyContent: 'start',
	gap: '1rem'
}
const rightPanelStyle = {
	width:'55vw',
	padding: '2rem',
	display: 'flex',
	flexDirection: 'column',
	alignItems: 'center',
	justifyContent: 'start',
	gap: '0.5rem'
}

const textStyle = {
	color: "grey",
	textAlign: "center"

}
export default Content;

