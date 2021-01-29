using System.Collections;
using System.Collections.Generic;
using System.Text;
using UnityEngine;

using WebSocketSharp;

public class WebSocketDemo : MonoBehaviour
{
    public TextField output;
    private WebSocket ws;

    // Use this for initialization
    void Start()
    {

        Debug.Log("Trying to connect to server");

        // Create WebSocket instance
        this.ws = new WebSocket("ws://localhost:4132/");

        // Add OnOpen event listener
        this.ws.OnOpen += (sender,e ) =>
        {
            Debug.Log("WS connected!");

            this.ws.Send("Hello from Unity 3D!");
            
        };

        // Add OnMessage event listener
        this.ws.OnMessage += (sender, e) =>
        {
            Debug.Log("WS received message: " + e.Data);
        };

        // Add OnError event listener
        this.ws.OnError += (sender, e) =>
        {
            Debug.Log("WS error");
        };

        // Connect to the server
        this.ws.Connect();

    }



    // Update is called once per frame
    void Update()
    {
        
    }
}
