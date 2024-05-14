import logo from './logo.svg';
import './App.css';
import {Layout} from "antd";
import Header from "./components/header";
import Content from "./components/content";


function App() {
  return (
      <Layout style={{ minHeight: '100vh' }}>
        <Header/>
        <Layout>
          <Content></Content>
        </Layout>
      </Layout>
  );
}

export default App;
