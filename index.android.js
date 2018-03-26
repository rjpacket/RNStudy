'use strict';
 import React from 'react';
 import TabNavigator from 'react-native-tab-navigator';
 import {
   AppRegistry,
   StyleSheet,
   Text,
   Image,
   View
 } from 'react-native';
 class Btn extends React.Component{
    render() {
        return (
            <Text style={styles.hello}>Hello {this.props.name}</Text>
        );
    }
 }

 class Blink extends React.Component{
    constructor(props){
        super(props);
        this.state = {time:60};

        var interval = setInterval(() => {
            if(this.state.time <= 0){
                clearInterval(interval);
                return;
            }
            this.setState({ time:--this.state.time });
        } , 1000);
    }

    render(){
        let display = this.state.time;
        return (
            <Text>{display}</Text>
        );
    }
 }

 var URL = "https://www.apiopen.top/meituApi?page=1";

 class WebImage extends React.Component{
    constructor(props){
        super(props);

        this.state = {
            images : null,
        };
    }

    render(){
        if(!this.state.images){
            return this.renderLoadingView();
        }
        var image = this.state.images[0];
        return this.renderImage(image);
    }

    fetchData(){
        fetch(URL, {method: "GET"})
        .then((response) => response.json())
        .then((result) => {this.setState({images:result.data})})
        .catch((error) => {
            callback(error);
        });
    }

    componentDidMount(){
        this.fetchData();
    }

    renderLoadingView(){
        return (
            <View style={styles.container}>
            <Text>
            正在加载电影数据......
            </Text>
            </View>
            );
    }

        renderImage(image)
        {
            return (
                <View style={styles.container}>
                    <Image source={{uri:image.url}}
                    style={styles.thumbnail} />
                    <View style={styles.rightContainer}>
                        <Text>{image.type}</Text>
                        <Text>{image.createdAt}</Text>
                    </View>
                </View>
                );
        }
 }

 class HelloWorld extends React.Component {
    constructor(props){
            super(props);

            this.state = {
                selectedTab : "home",
            };
        }

   render() {
     return (
       <View style={styles.container}>
         <Text style={styles.hello}>Hi!第一个项目诞生了！</Text>
         <Btn name="rjp1"></Btn>
         <Btn name="rjp2"></Btn>
         <Blink  />
         <WebImage />

         <TabNavigator>
            <TabNavigator.Item
                selected = {this.state.selectedTab === "home"}
                title="首页"
                renderIcon = {() => <Image source={require("./home1.png")} />}
                renderSelectedIcon = {() => <Image source={require("./home1.png")} />}
                onPress={() => this.setState({ selectedTab: "home"})}
                <View style={styles.container}>
                     <Text style={{fontSize:18,padding:15,color: 'white'}}>This is Event Page1</Text>
                </View>
            >
            </TabNavigator.Item>
            <TabNavigator.Item
                selected = {this.state.selectedTab === "mine"}
                title="我的"
                renderIcon = {() => <Image source={require("./home1.png")} />}
                renderSelectedIcon = {() => <Image source={require("./home1.png")} />}
                onPress={() => this.setState({ selectedTab: "mine"})}
                <View style={styles.container}>
                    <Text style={{fontSize:18,padding:15,color: 'gray'}}>This is Event Page2</Text>
                </View>
            >
            </TabNavigator.Item>
         </TabNavigator>
       </View>
     )
   }
 }

 var styles = StyleSheet.create({
   container: {
     flex: 1,
     justifyContent: 'center',
   },
   hello: {
     fontSize: 20,
     textAlign: 'center',
     margin: 10,
   },
   thumbnail:{
           width:100,height:80
       },
   rightContainer:{
           flex:1
       },
 });
 AppRegistry.registerComponent('HelloWorld', () => HelloWorld);