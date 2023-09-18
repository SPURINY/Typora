# Typora
my notes<br/>
提交指令：
https://blog.csdn.net/qq_39588003/article/details/115670602<br/>
23.9.17:<br/>
之前复制的图片都在c盘，用typora替换功能改的路径，不知道为啥打开有的图片无了，随缘~~<br/>
<br/>
要提交本地仓库的更改到GitHub仓库，你可以按照以下步骤进行操作：<br/>
1.确保本地仓库与GitHub仓库同步：<br/>
在你的本地仓库目录中打开终端或命令行工具。<br/>
运行 `git pull origin main`（假设你的GitHub主分支是main，如果是master或其他分支，请相应地替换）。这将拉取GitHub仓库上的最新更改并合并到你的本地分支。<br/>
2.添加更改到暂存区：<br/>
使用 git add 命令将你的更改添加到Git的暂存区。你可以通过以下命令添加所有更改：<br/>
`git add *`<br/>
或者，如果你只想添加特定文件或文件夹，可以使用：<br/>
`git add <文件或文件夹名称>`<br/>
3.提交更改：<br/>
使用 git commit 命令提交你的更改并添加一个提交消息：<br/>
`git commit -m "描述你的更改的信息"`<br/>
4.推送更改到GitHub：<br/>
使用 git push 命令将你的本地更改推送到GitHub仓库：<br/>
`git push origin main`<br/>
同样，请根据你的GitHub主分支的名称进行相应的替换。<br/>
5.验证更改：<br/>
访问GitHub仓库的网页界面，确保你的更改已成功推送到GitHub仓库。<br/>
现在，你的本地更改已提交到GitHub仓库，并且与GitHub上的仓库同步。如果你在GitHub仓库上创建了一个新的文件夹，或者修改了已存在的文件，这些更改应该反映在你的GitHub仓库中。<br/>

＋可能itzy节点断开了
