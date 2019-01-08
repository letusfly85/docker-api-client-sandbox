package main

import (
	"bytes"
	"fmt"
	"github.com/fsouza/go-dockerclient"
)


// https://github.com/fsouza/go-dockerclient/blob/master/image.go#L303:L322
func main() {
	endpoint := "unix:///var/run/docker.sock"
	client, err := docker.NewClient(endpoint)
	if err != nil {
		panic(err)
	}
	imgs, err := client.ListImages(docker.ListImagesOptions{All: false})
	if err != nil {
		panic(err)
	}
	for _, img := range imgs {
		fmt.Println("ID: ", img.ID)
		fmt.Println("RepoTags: ", img.RepoTags)
		fmt.Println("Created: ", img.Created)
		fmt.Println("Size: ", img.Size)
		fmt.Println("VirtualSize: ", img.VirtualSize)
		fmt.Println("ParentId: ", img.ParentID)
	}

	var buf bytes.Buffer
	err = client.PullImage(
		docker.PullImageOptions{
			Repository: "jenkins/jenkins",
			Registry: "docker.io",
			Tag: "lts-slim",
			OutputStream: &buf},
		docker.AuthConfiguration{},
	)
	if err != nil {
		panic(err)
	}
	// this is not async progress
	fmt.Println("Progress", buf.String())
}
