stage 'Load files from GitHub'
def environment, helloworld
fileLoader.withGit('https://github.com/smuvw/Demo_pipeline.git', 'master', null, '') {
    helloworld = fileLoader.load('seed2');
   
}

stage 'Run methods from the loaded content'
helloworld.add()
helloworld.sub()

