import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import React from 'react';
import {Layout, Menu} from 'antd';

function Header() {
	return (
		<Layout.Header
			className='verve-header'
			style={headerStyle}>
			<FontAwesomeIcon icon="fa-regular fa-diagram-project" />
			<Menu theme="dark" defaultSelectedKeys={['home']} mode="horizontal" >
				<Menu.Item key="home">
					Home
				</Menu.Item>
			</Menu>
		</Layout.Header>
	);
}

// Styles
const headerStyle = {
	alignItems: 'center',
};

export default Header;